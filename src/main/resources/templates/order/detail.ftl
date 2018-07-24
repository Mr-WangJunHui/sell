<html>
    <head>
        <meta charset="utf-8">
        <title>订单详情列表</title>
        <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-6 column">
                <table class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th>订单号</th>
                        <th>买家姓名</th>
                        <th>总价</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${orderDTO.orderId}</td>
                        <th>${orderDTO.buyerName}</th>
                        <td>${orderDTO.orderAmount}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-12 column">
                <table class="table table-bordered table-condensed">
                    <thead>
                    <tr>
                        <th>商品名称</th>
                        <th>商品价格</th>
                        <th>商品数量</th>
                        <th>创建时间</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderDetails as orderDetail>
                        <tr>
                            <td>${orderDetail.productName}</td>
                            <td>${orderDetail.productPrice}</td>
                            <td>${orderDetail.productQuantity}</td>
                            <td>${orderDetail.createTime}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            <div class="col-md-12 column">
                 <#if orderDTO.getOrderStatusEnum().getMsg() == "完结">
                     <button type="button" class="btn btn-lg btn-success active">
                         订单已完结
                     </button>
                 </#if>
                <#if orderDTO.getOrderStatusEnum().getMsg() == "已取消">
                     <button type="button" class="btn btn-lg btn-danger active">
                         订单已取消
                     </button>
                </#if>
                <#if orderDTO.getOrderStatusEnum().getMsg() == "新下单">
                     <button type="button" class="btn btn-lg btn-success active">
                    <a href="/sell/buyer/order/behindFinished?orderId=${orderDTO.orderId}">完结订单</a>
                </button>
                    <button type="button" class="btn btn-danger btn-lg active">
                        <a href="/sell/buyer/order/behindCancel?orderId=${orderDTO.orderId}">取消订单</a>
                    </button>
                </#if>
            </div>
        </div>
    </div>
    </body>
</html>