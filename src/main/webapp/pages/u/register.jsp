<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qiudaozhang
  Date: 2019/10/7
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <link rel="stylesheet" href="${ctx}/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <jsp:include page="/pages/fragment/header.jsp"></jsp:include>
    <jsp:include page="/pages/fragment/left-nav.jsp"></jsp:include>



    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">

            <form class="layui-form" action="${ctx}/u/register" method="post" enctype="multipart/form-data">
                <div class="layui-form-item">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="loginCode"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">真实姓名：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="userName"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">证件类型</label>
                    <div class="layui-input-inline">
                        <select name="cardType" lay-verify="">
                           <c:forEach items="${cardTypes}" var="obj">
                               <option value="${obj.valueId}">${obj.valueName}</option>
                           </c:forEach>
                        </select>
                    </div>
                    <label class="layui-form-label">证件号码：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="idCard"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">移动电话：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="mobile"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">电子邮件：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="email"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">邮政编码：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="postCode"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">推荐人：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="recommender.userName"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">收货国家：</label>
                    <div class="layui-input-inline">
                        <select name="country" lay-verify="">
                            <c:forEach items="${countries}" var="obj">
                                <option value="${obj.cname}">${obj.cname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">开户行：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="bankName"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                    <label class="layui-form-label">开户人：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="accountHolder"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">开户卡号：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="bankAccount"   lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上传身份证正面</label>
                    <div class="layui-input-block">
                        <input type="file" name="idCardPicPosPathFile"    lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上传身份证反面</label>
                    <div class="layui-input-block">
                        <input type="file" name="idCardPicNegPathFile"    lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上传银行卡图片</label>
                    <div class="layui-input-block">
                        <input type="file" name="bankPicPathFile"    lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">收货地址</label>
                    <div class="layui-input-block">
                        <textarea name="userAddress" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
    </div>
</div>
<script src="${ctx}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element','form'], function(){
        var element = layui.element;
        var form = layui.form;

    });
</script>
</body>
</html>