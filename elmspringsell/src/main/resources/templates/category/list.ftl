<html>
<#include "../common/header.ftl">
<body>
<#include "../common/nav.ftl">
<div class="container">
    <h3>类目列表</h3>
    <table class="table table-bordered table-condensed">
        <thead>
        <tr>
            <th>类目id</th>
            <th>类目名字</th>
            <th>类目类型</th>
            <th>创建时间</th>
            <th>修改时间</th>
            <th>操作类目</th>
        </tr>
        </thead>
        <tbody id="context">

        <#list categoryList as category>
            <tr>
                <td>${category.categoryId}</td>
                <td>${category.categoryName}</td>
                <td>${category.categoryType}</td>
                <td>${category.createTime}</td>
                <td>${category.updateTime}</td>
                <td><a href="/sell/seller/category/index?categoryId=${category.categoryId}">修改</a></td>
            </tr>
        </#list>

        </tbody>
    </table>


</div>
<#include "../common/tailer.ftl">
</body>
</html>