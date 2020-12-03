<html>
<#include "../common/header.ftl">
<body>
<#include "../common/nav.ftl">
<div class="container">
    <div class="row">
        <table class="table table-bordered table-hover">
            <h3 class="">商品列表</h3>
            <thead>
            <tr class="warning">
                <th>商品Id</th>
                <th>名称</th>
                <th>图片</th>
                <th>单价</th>
                <th>库存</th>
                <th>描述</th>
                <th>类目</th>
                <th>创建时间</th>
                <th>修改时间</th>
                <th colspan="2">操作</th>
            </tr>
            </thead>
            <tbody>
            <#list productInfoPage.content as productInfo>
                <tr>
                    <td>${productInfo.productId}</td>
                    <td>${productInfo.productName}</td>
                    <td>
                        <img src="${productInfo.productIcon}" height="100px" width="100px">
                    </td>
                    <td>${productInfo.productPrice}</td>
                    <td>${productInfo.productStock}</td>
                    <td>${productInfo.productDescription}</td>
                    <td>${productInfo.categoryType}</td>
                    <td>${productInfo.createTime}</td>
                    <td>${productInfo.updateTime}</td>
                    <td><a href="/sell/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                    <#if productInfo.productStatus == 0>
                        <td><a href="/sell/seller/product/sale?productId=${productInfo.productId}&productStatus=${productInfo.productStatus}">下架</a></td>
                        <#else >
                            <td><a href="/sell/seller/product/sale?productId=${productInfo.productId}&productStatus=${productInfo.productStatus}">取消</a></td>
                    </#if>

                </tr>
            </#list>
        </table>
    </div>

    <div class="col-md-12 column">
        <ul class="pagination pull-right">
            <#if currentPage lte 1>
                <li class="disabled"><a href="#">上一页</a></li>
                <#else >
                    <li><a href="/sell/seller/product/list?page=${currentPage-1}&size=${size}">上一页</a></li>
            </#if>

            <#list 1..productInfoPage.getTotalPages() as index>
            <#if currentPage == index>
                <li class="disabled"><a href="#">${index}</a></li>
                <#else >
                    <li><a href="/sell/seller/product/list?page=${index}&size=${size}">${index}</a></li>
            </#if>
            </#list>

            <#if currentPage gte productInfoPage.getTotalPages()>
                <li class="disabled"><a href="#">下一页</a></li>
            <#else >
                <li><a href="/sell/seller/product/list?page=${currentPage+1}&size=${size}">下一页</a></li>
            </#if>
        </ul>
    </div>


</div>
<#include "../common/tailer.ftl">
</body>
</html>