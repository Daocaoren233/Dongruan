<html>
<#include "../common/header.ftl">
<body>
<#include "../common/nav.ftl">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" method="post" action="/sell/seller/category/save">
                <div class="form-group">
                    <label for="exampleInputEmail1">类目名字</label>
                    <input name="categoryName" type="text" class="form-control" value="${category.categoryName!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">类目类型</label>
                    <input name="categoryType" type="text" class="form-control" value="${category.categoryType!''}">
                </div>

                <input hidden type="text" name="categoryId" value="${category.categoryId!''}">
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>


</div>
<#include "../common/tailer.ftl">
</body>
</html>