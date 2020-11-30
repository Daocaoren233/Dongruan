<html>
<head>
    <meta charset="utf-8">
    <title>卖家后端管理系统</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/sell/css/style.css">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        商品编号
                    </th>
                    <th>
                        商品备注
                    </th>
                    <th>
                        商品类型
                    </th>
                    <th>
                        创建时间
                    </th>
                    <th>
                        更新时间
                    </th>
                    <th>
                        操作事项
                    </th>
                </tr>
                </thead>
                <tbody>
                <#list categoryList as category>
                    <tr class="success">
                        <td>
                            ${category.categoryId}
                        </td>
                        <td>
                            ${category.categoryName}
                        </td>
                        <td>
                            ${category.categoryType}
                        </td>
                        <td>
                            ${category.createTime}
                        </td>
                        <td>
                            ${category.updateTime}
                        </td>
                        <td>
                            <button>删除</button>
                            <button>添加</button>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>