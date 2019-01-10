package cn.lemonsports.util;

/**
 * 操作结果反馈
 */
public class AjaxResult {
    private Boolean success=true;
    private String message="操作成功啦！";
    private Object object;

    public Object getObject() {
        return object;
    }

    public AjaxResult setObject(Object object) {
        this.object = object;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public AjaxResult setSuccess(Boolean success) {
        this.success = success;
        return this;//可实现链式编程
    }

    public String getMessage() {
        return message;
    }

    public AjaxResult setMessage(String message) {
        this.message = message;
        return this;
    }
    public static AjaxResult getAjaxResult(){//直接调用该静态方法获取AjaxResult对象
        return new AjaxResult();
    }
}
