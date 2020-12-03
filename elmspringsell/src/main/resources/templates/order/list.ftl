<html>
<#include "../common/header.ftl">
<body>
<#include "../common/nav.ftl">
<div class="container">
    <div class="row">
        <table class="table table-bordered table-hover">
            <h3 class="">订单列表</h3>
            <thead>
            <tr class="warning">
                <th>订单Id</th>
                <th>姓名</th>
                <th>手机号</th>
                <th>地址</th>
                <th>金额</th>
                <th>订单状态</th>
                <th>支付状态</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th colspan="2">操作</th>
            </tr>
            </thead>
            <tbody>
            <#list orderMasterPage.content as orderMaster>
                <tr>
                    <td>${orderMaster.orderId}</td>
                    <td>${orderMaster.buyerName}</td>
                    <td>${orderMaster.buyerPhone}</td>
                    <td>${orderMaster.buyerAddress}</td>
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
                    <td><a href="/sell/seller/order/detail?orderId=${orderMaster.orderId}">详情</a></td>
                    <td><a href="/sell/seller/order/move?orderId=${orderMaster.orderId}">
                            <#if orderMaster.orderStatus == 0>
                                取消
                            </#if>
                        </a></td>

                </tr>
            </#list>
        </table>
    </div>

    <div class="col-md-12 column">
        <ul class="pagination pull-right">
            <#if currentPage lte 1>
                <li class="disabled"><a href="#">上一页</a></li>
            <#else >
                <li><a href="/sell/seller/order/list?page=${currentPage-1}&size=${size}">上一页</a></li>
            </#if>

            <#list 1..orderMasterPage.getTotalPages() as index>
                <#if currentPage == index>
                    <li class="disabled"><a href="#">${index}</a></li>
                <#else >
                    <li><a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                </#if>
            </#list>

            <#if currentPage gte orderMasterPage.getTotalPages()>
                <li class="disabled"><a href="#">下一页</a></li>
            <#else >
                <li><a href="/sell/seller/order/list?page=${currentPage+1}&size=${size}">下一页</a></li>
            </#if>
        </ul>
    </div>


</div>
<#include "../common/tailer.ftl">
</body>
</html>