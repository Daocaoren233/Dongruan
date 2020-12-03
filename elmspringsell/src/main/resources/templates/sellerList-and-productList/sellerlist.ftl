<html>
<#include  "../common/cheader.ftl">
<body style="background-color: #adadad">
<#include "../common/discnav.ftl">
<div class="container" >
<h3>商家</h3>
    <div class="row">
        <#list sellerInfoList as seller>
            <div class="col-sm-6 col-md-3">
                <div class="thumbnail" style="background-color: #c4e3f3">
                    <a href="/sell/consumer/buy/detail?sellerId=${seller.id}">
                    <img src="https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2842608673,181190825&fm=26&gp=0.jpg" height="100px" width="100px" style="padding-top: 40px">
                    </a>
                    <div class="caption" >
                        <h3 class="text-center text-info">${seller.username}</h3>
                    </div>
                </div>
            </div>
        </#list>
    </div>


</div>
<#include "../common/tailer.ftl">
<script>
    function login(){
        alert("请先登录鸭！！！");
    }
</script>
</body>
</html>