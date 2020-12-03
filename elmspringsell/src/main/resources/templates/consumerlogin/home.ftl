<html>
<#include  "../common/cheader.ftl">
<body>
<div class="container-fluid" style="background-color: #a6e1ec">
    <#include "../common/cnav.ftl">
    <#include "../common/imgturn.ftl">
    <div class="row" style="margin-top: 20px">
        <ul class="breadcrumb">
            <li><a href="#">热门推荐</a></li>
            <li><a href="#">2020</a></li>
            <li class="active">美食与你都不能辜负</li>
        </ul>
    </div>

    <div class="row" >
        <#list productInfoList as productInfo>
            <div class="col-sm-6 col-md-3" >
                <div class="thumbnail" style="background-color: #c4e3f3">
                    <img src="${productInfo.productIcon}" height="100px" width="100px" style="padding-top: 40px">
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
</body>
</html>