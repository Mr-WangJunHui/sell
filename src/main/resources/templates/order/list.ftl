<html>
    <head>
        <meta charset="utf-8">
        <title>商品列表</title>
        <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-condensed table-bordered">
                    <thead>
                    <tr>
                        <th>订单编号</th>
                        <th>买家姓名</th>
                        <th>买家电话</th>
                        <th>买家地址</th>
                        <th>买家的微信openid</th>
                        <th>订单总金额</th>
                        <th>订单状态</th>
                        <th>支付状态</th>
                        <th>创建时间</th>
                        <th colspan="2">操作</th>
                    </tr>
                    </thead>
                    <tbody>
                   <#list orderList as orderDTO>
                   <tr>
                       <td>${orderDTO.orderId}</td>
                       <td>${orderDTO.buyerName}</td>
                       <td>${orderDTO.buyerPhone}</td>
                       <td>${orderDTO.buyerAddress}</td>
                       <td>${orderDTO.buyerOpenid}</td>
                       <td>${orderDTO.orderAmount}</td>
                       <td>${orderDTO.getOrderStatusEnum().getMsg()}</td>
                       <td>${orderDTO.getPayStatusEnum().getMsg()}</td>
                       <td>${orderDTO.createTime}</td>
                       <td><a href="/sell/buyer/order/hehindDetailList?orderId=${orderDTO.orderId}">详情</a></td>
                       <#if orderDTO.getOrderStatusEnum().getMsg() == "新下单" >
                       <td> <a href="/sell/buyer/order/behindCancel?orderId=${orderDTO.orderId}">取消</a></td>
                       <#else>
                        <td></td>
                       </#if>

                   </tr>
                   </#list>
                    </tbody>
                </table>
            </div>
            <div class="col-md-12 column">
                <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                      <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                      <li><a href="/sell/buyer/order/behindList?page=${currentPage-1}&size=${size}">上一页</a></li>
                    </#if>
                    <#if totalPage gte 5>
                        <#list 1..totalPage as index>
                           <#if index lte 4>
                               <#if index == currentPage>
                                 <li class="disabled"><a href="#">${index}</a></li>
                               <#else>
                                 <li><a href="/sell/buyer/order/behindList?page=${index}&size=${size}">${index}</a></li>
                               </#if>
                            <#else>
                               <#if currentPage+1 == index>
                                   <li><a href="/sell/buyer/order/behindList?page=${index}&size=${size}">${index}</a></li>
                               </#if>
                               <#if index == totalPage>
                               <#else>
                                  <li class="disabled"><a href="#">.</a></li>
                               </#if>
                           </#if>
                        </#list>
                    <#else>
                        <#list 1..totalPage as index>
                            <#if index == currentPage>
                           <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                           <li><a href="/sell/buyer/order/behindList?page=${index}&size=${size}">${index}</a></li>
                            </#if>
                        </#list>
                    </#if>


                    <#if currentPage gte totalPage>
                       <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                       <li><a href="/sell/buyer/order/behindList?page=${currentPage+1}&size=${size}">下一页</a></li>
                    </#if>

                </ul>
            </div>
        </div>
    </div>
    </body>
</html>