<%--
  Created by IntelliJ IDEA.
  User: qiudaozhang
  Date: 2019/10/7
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <%--                layui-nav-itemed--%>
            <li class="layui-nav-item">
                <a class="" href="javascript:;">后台管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/sys/u/to/list">用户管理</a></dd>
                    <dd><a href="${ctx}/role/to/roleList">角色管理</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">会员管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="${ctx}/u/to/register">注册新会员</a></dd>
                    <dd><a href="${ctx}/u/toList">新会员管理</a></dd>
                    <dd><a href="${ctx}/u/toModify">修改本人资料</a></dd>
                    <dd><a href="${ctx}/u/toModifyPwd">修改本人密码</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">电子银行</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">列表一</a></dd>
                    <dd><a href="javascript:;">列表二</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">购物管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">列表一</a></dd>
                    <dd><a href="javascript:;">列表二</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">信息查询</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">列表一</a></dd>
                    <dd><a href="javascript:;">列表二</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">咨询管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">列表一</a></dd>
                    <dd><a href="javascript:;">列表二</a></dd>
                </dl>
            </li>

        </ul>
    </div>
</div>
