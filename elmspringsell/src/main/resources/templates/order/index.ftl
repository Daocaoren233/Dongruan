<html>
<#include "../common/header.ftl">
<body>
<#include "../common/nav.ftl">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" method="post" action="/sell/seller/order/save">

                <div class="form-group">
                    <label for="exampleInputEmail1">姓名</label>
                    <input name="buyerName" type="text" class="form-control" value="${orderMaster.buyerName!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">手机号</label>
                    <input name="buyerPhone" type="text" class="form-control" value="${orderMaster.buyerPhone!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">地址</label>
                    <input name="buyerAddress" type="text" class="form-control" value="${orderMaster.buyerAddress!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">微信</label>
                    <input name="buyerOpenid" type="text" class="form-control" value="${orderMaster.buyerOpenid!''}">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">金额</label>
                    <input name="orderAmount" type="text" class="form-control" value="${orderMaster.orderAmount!''}">
                </div>

                <input hidden name="orderId" type="text" value="${orderMaster.orderId!''}">

                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
    </div>


</div>
<#include "../common/tailer.ftl">
</body>
</html>