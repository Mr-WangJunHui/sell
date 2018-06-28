package com.imooc.sell.utlis;

import com.imooc.sell.vo.ResultVo;

public class ResultVOUtils {
    /**
     * 返回前台的结果封装，成功时带正确数据的返回
     * @param object
     * @return
     */
    public static ResultVo success(Object object){
        ResultVo  resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return resultVo ;
    }

    /**
     * 成功时不带数据的返回
     * @return
     */
    public static ResultVo success(){
        return success(null);
    }

    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
}
