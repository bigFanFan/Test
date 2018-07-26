package com.lxs.common;

/**
 * @author Limiaojun
 * @Description 返回结果集
 * @date 2017年3月21日
 */
public class BaseResult<T> {


    private boolean success;

    private String msg;

    private T datas;

    public BaseResult msg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", datas=" + datas +
                '}';
    }

    private BaseResult() {
    }

    private BaseResult(Builder builder) {
        this.success = builder.success;
        this.msg = builder.msg;
        this.datas = (T) builder.datas;
    }

    private static <T> Builder<T> builder() {
        return new BaseResult.Builder<T>();
    }

    public static class Builder<T> {
        private boolean success;

        private String msg;

        private T datas;

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder datas(T datas) {
            this.datas = datas;
            return this;
        }

        public BaseResult build() {
            return new BaseResult(this);
        }
    }


    public static <T> BaseResult<T> ok() {

        return BaseResult.builder().success(true).msg("操作成功").build();
    }

    public static <T> BaseResult<T> ok(T t) {
        return BaseResult.builder().success(true).msg("操作成功").datas(t).build();
    }

    public static <T> BaseResult<T> badRequest() {
        return BaseResult.builder().success(false).msg("操作失败").build();
    }

    public static <T> BaseResult<T> badRequest(T t) {
        return BaseResult.builder().success(false).msg("操作失败").datas(t).build();
    }

    public static void main(String[] args) {
        System.out.println(ok());
    }


}
