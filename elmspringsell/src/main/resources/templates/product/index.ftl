<html>
<#include "../common/header.ftl">
<body>
<#include "../common/nav.ftl">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" method="post" action="/sell/seller/product/save">
                <div class="form-group">
                    <label for="exampleInputEmail1">商品名称</label>
                    <input name="productName" type="text" class="form-control" value="${productInfo.productName!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">价格</label>
                    <input name="productPrice" type="text" class="form-control" value="${productInfo.productPrice!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">库存</label>
                    <input name="productStock" type="text" class="form-control" value="${productInfo.productStock!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">商品描述</label>
                    <input name="productDescription" type="text" class="form-control" value="${productInfo.productDescription!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">商品图片</label>
                    <img src="${productInfo.productIcon!''}" height="100px" width="100px">
                    <input name="productIcon" type="text" class="form-control" value="${productInfo.productIcon!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">类目</label>
                    <select name="categoryType" class="form-group">
                        <#list categoryList as category>
                            <option value="${category.categoryType}"
                                    <#if (productInfo.categoryType)?? && category.categoryType == productInfo.categoryType>
                                        selected
                                    </#if>
                            >${category.categoryName}</option>
                        </#list>

                    </select>
                </div>

                <input hidden type="text" name="productId" value="${productInfo.productId!''}">
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>


</div>
<#include "../common/tailer.ftl">
</body>
</html>