<html>
<#include "../common/cheader.ftl">
<body>
<div class="container-fluid">
    <div class="row clearfix" style="margin-top: 100px">
        <div class="col-md-4 column"></div>
        <div class="col-md-4 column">
            <h3>商家注册:</h3>
            <form role="form" method="post" action="/sell/login/save">
                <div class="form-group">
                    <label for="exampleInputEmail1">商家名称</label>
                    <input name="username" type="text" class="form-control">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">密码</label>
                    <input name="password" type="password" class="form-control">
                </div>

                <div class="form-group">
                    <label for="exampleInputEmail1">微信Id</label>
                    <input name="openid" type="text" class="form-control">
                </div>

                <div class="row">
                    <div class="col-md-10 column"></div>
                    <div class="col-md-1 column">
                        <button type="submit" class="btn btn-default">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>





</div>
<#include "../common/tailer.ftl">
</body>
</html>