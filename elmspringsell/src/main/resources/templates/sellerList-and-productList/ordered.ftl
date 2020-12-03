<html>
<#include  "../common/cheader.ftl">
<body  style="background-color: #a6e1ec">
<div class="container-fluid">
    <#include "../common/cnav.ftl">

    <div class="row" >
        <#list productInfoList as productInfo>
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail" style="background-color: #c4e3f3">
                    <a href="#">
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
    <div class="row">
        <div class="col-md-11"></div>
        <div class="col-md-1">
            <a class="text-danger" href="/sell/consumer/buy/overorder" onclick="success1()">提交订单</a>
<#--            <button class="btn btn-warning" href="/sell/consumer/buy/overorder" onclick="success1()">提交订单</button>-->
        </div>
    </div>



</div>
<#include "../common/tailer.ftl">
<script>
    function success(){
        alert("添加成功！！！");
    }
    function success1(){
        alert("订单提交成功！！！");
    }
</script>
</body>
</html>