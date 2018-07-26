package com.lhiot.basic.api;

import com.swetake.util.Qrcode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URLDecoder;

/**
* Description:二维码生成接口类
* @author yijun
* @date 2018/07/24
*/
@Api(description = "二维码生成接口")
@Slf4j
@RestController
@RequestMapping("/qrcode")
public class QrCodeApi {


    @Autowired
    public QrCodeApi() {
    }

    @GetMapping("/create")
    @ApiOperation(value = "二维码生成")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "info", value = "二维码信息", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "尺寸大小(PX)", required = true, dataType = "int")
    })
    public void createQrImg(@RequestParam String info,@RequestParam int size, HttpServletResponse response) throws Exception {
        log.debug("二维码生成\t param:{}",info);
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');
        qrcode.setQrcodeEncodeMode('B');
        qrcode.setQrcodeVersion(7);
        byte[] d = URLDecoder.decode(info,"utf-8").getBytes("utf-8");
        BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g = image.createGraphics();
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, size, size);
        g.setColor(Color.BLACK);
        if (d.length > 0 && d.length < 120) {
            boolean[][] s = qrcode.calQrcode(d);
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        g.fillRect(j * 2 + 3, i * 2 + 3, 2, 2);
                    }
                }
            }
        }
        g.dispose();
        image.flush();
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
}
