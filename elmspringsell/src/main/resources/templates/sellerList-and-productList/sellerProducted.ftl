<html>
<#include  "../common/cheader.ftl">
<body>
<div class="container-fluid" style="background-color: #a6e1ec">
    <#include "../common/cnav.ftl">

    <h3>${name} 的商品：</h3>

    <div class="row" >
        <#list productInfoList as productInfo>
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail" style="background-color: #c4e3f3">
                    <a onclick="success()" href="/sell/consumer/buy/saveorder?productId=${productInfo.productId}">
                        <img src="${productInfo.productIcon}" style="padding-top: 40px;height: 100px;width: 100px">
                    </a>
                    <div class="caption" >
                        <h3 class="text-center text-info">名称：${productInfo.productName}</h3>
                        <p class="text-center text-success">描述：${productInfo.productDescription}</p>
                        <p class="text-center text-danger">价格：${productInfo.productPrice}</p>
                        <p class="text-center text-success">更新时间：${productInfo.updateTime}</p>
                    </div>
                </div>
            </div>
        </#list>
    </div>




</div>
<#include "../common/tailer.ftl">
<script>
    function success(){
        alert("添加成功！！！");
    }
</script>
</body>
</html>