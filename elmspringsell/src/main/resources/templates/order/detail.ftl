<html>
<#include "../common/header.ftl">
<body>
<#include "../common/nav.ftl">
<div class="container">
    <div class="row">
        <table class="table table-bordered table-hover">
            <h3 class="">${orderMaster.buyerName} 的订单详情</h3>
            <thead>
            <tr class="warning">
                <th>订单Id</th>
                <th>姓名</th>
                <th>手机号</th>
                <th>地址</th>
                <th>微信</th>
                <th>金额</th>
                <th>订单状态</th>
                <th>支付状态</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${orderMaster.orderId}</td>
                <td>${orderMaster.buyerName}</td>
                <td>${orderMaster.buyerPhone}</td>
                <td>${orderMaster.buyerAddress}</td>
                <td>${orderMaster.buyerOpenid}</td>
                <td>${orderMaster.orderAmount}</td>
                <td>
                    <#if orderMaster.orderStatus == 0>
                        新订单
                    </#if>
                    <#if orderMaster.orderStatus == 1>
                        完结
                    </#if>
                    <#if orderMaster.orderStatus == 2>
                        已取消
                    </#if>
                </td>
                <td>
                    <#if orderMaster.payStatus == 1>
                        支付成功
                    <#else >
                        等待支付
                    </#if>
                </td>
                <td>${orderMaster.createTime}</td>
                <td>${orderMaster.updateTime}</td>
                <td><a href="/sell/seller/order/index?orderId=${orderMaster.orderId}">修改</a></td>
            </tr>
            </tbody>
        </table>
    </div>
    <hr>
    <div class="row">
        <table class="table table-bordered table-hover">
            <h4 class="">${orderMaster.buyerName} 购买商品详情</h4>
            <thead>
            <tr class="warning">
                <th>详情Id</th>
                <th>商品Id</th>
                <th>商品名称</th>
                <th>商品价格</th>
                <th>商品数量</th>
                <th>图片</th>
                <th>创建时间</th>
                <th>修改时间</th>
            </tr>
            </thead>
            <tbody>
            <#list orderDetailList as orderDetail>
                <tr>
                    <td>${orderDetail.detailId}</td>
                    <td>${orderDetail.productId}</td>
                    <td>${orderDetail.productName}</td>
                    <td>${orderDetail.productPrice}</td>
                    <td>${orderDetail.productQuantity}</td>
                    <td>
                        <img src="${orderDetail.productIcon}" width="100px" height="100px">
                    </td>
                    <td>${orderDetail.createTime}</td>
                    <td>${orderDetail.updateTime}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>


</div>
<#include "../common/tailer.ftl">
</body>
</html>