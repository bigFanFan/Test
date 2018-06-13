package com.lhiot.basic.api;

import com.leon.microx.common.wrapper.ArrayObject;
import com.lhiot.basic.domain.LocationParam;
import com.lhiot.basic.domain.Store;
import com.lhiot.basic.service.StoreService;
import com.lhiot.basic.common.PagerResultObject;
import com.lhiot.basic.common.util.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
* Description:门店接口类
* @author Limiaojun
* @date 2018/06/02
*/
@Api(description = "门店接口")
@Slf4j
@RestController
@RequestMapping("/stores")
@SuppressWarnings("rawtypes")
public class StoreApi {

    private final StoreService storeService;

    @Autowired
    public StoreApi(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping
    @ApiOperation(value = "添加门店")
    @ApiImplicitParam(paramType = "body", name = "store", value = "要添加的门店", required = true, dataType = "Store")
    public ResponseEntity<Integer> create(@RequestBody Store store) {
        log.debug("添加门店\t param:{}",store);

        return ResponseEntity.ok(storeService.create(store));
    }

    @PutMapping
    @ApiOperation(value = "根据id更新门店")
    @ApiImplicitParam(paramType = "body", name = "store", value = "要更新的门店", required = true, dataType = "Store")
    public ResponseEntity<Integer> update(@RequestBody Store store) {
        log.debug("根据id更新门店\t param:{}",store);

        return ResponseEntity.ok(storeService.updateById(store));
    }

    @DeleteMapping("/{ids}")
    @ApiOperation(value = "根据ids删除门店")
    @ApiImplicitParam(paramType = "path", name = "ids", value = "要删除门店的ids,逗号分割", required = true, dataType = "String")
    public ResponseEntity<Integer> deleteByIds(@PathVariable("ids") String ids) {
        log.debug("根据ids删除门店\t param:{}",ids);

        return ResponseEntity.ok(storeService.deleteByIds(ids));
    }

    @ApiOperation(value = "根据id查询门店", notes = "根据id查询门店")
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public ResponseEntity<Store> findStore(@PathVariable("id") Long id) {

        return ResponseEntity.ok(storeService.selectById(id));
    }

    @PostMapping("/page/query")
    @ApiOperation(value = "查询门店分页列表")
    public ResponseEntity<PagerResultObject<Store>> pageQuery(Store store){
        log.debug("查询门店分页列表\t param:{}",store);

        return ResponseEntity.ok(storeService.pageList(store));
    }

    @GetMapping("position")
    @ApiOperation(value = "根据位置查询门店所有列表")
    public ResponseEntity<ArrayObject> findPosition(LocationParam param){
        log.debug("根据位置查询门店列表\t param:{}",param);

        return ResponseEntity.ok(ArrayObject.of(storeService.findStoresSortByDistance(param)));
    }

    @GetMapping("position/lately")
    @ApiOperation(value = "根据位置返回最近的门店")
    public ResponseEntity<Store> findPositionLately(LocationParam param){
        log.debug("根据位置返回最近的门店\t param:{}",param);
        List<Store> resultList = storeService.findStoresSortByDistance(param);

        return ResponseEntity.ok((Store)CommonUtils.getCollectionsFirst(resultList));
    }

    @ApiOperation(value = "根据用户位置查询附近(200km内)门店", notes = "定标位置查询附近(200km内)门店列表")
    @GetMapping(value = "/nearstores")
    public ResponseEntity<ArrayObject> findNearbyStores(LocationParam param) throws ParseException {
        log.debug("根据用户位置查询附近(200km内)门店\t param:{}",param);
        List<Store> list = storeService.findUserNearbyStores(param.getLocationX(), param.getLocationY(), 200, 22);
        return ResponseEntity.ok(ArrayObject.of(list));
    }

    @ApiOperation(value = "根据ids获取门店信息(id和名称)",response=Store.class)
    @ApiImplicitParam(paramType = "query", name = "storeIds", value = "门店Id集合", required = true, dataType = "String")
    @GetMapping("/names")
    public ResponseEntity<ArrayObject> findStoreNames(@RequestParam String storeIds){
        return ResponseEntity.ok(ArrayObject.of(storeService.findStoreList(storeIds)));
    }

    @GetMapping("manage/all")
    @ApiOperation(value = "后台管理-获取所有门店信息")
    public ResponseEntity<ArrayObject> findAllStores(){
        log.debug("后台管理-获取所有门店信息");

        return ResponseEntity.ok(ArrayObject.of(storeService.findAllStores()));
    }

}
