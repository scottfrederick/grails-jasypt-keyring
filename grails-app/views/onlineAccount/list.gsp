
<%@ page import="grails.keyring.OnlineAccount" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'onlineAccount.label', default: 'OnlineAccount')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'onlineAccount.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'onlineAccount.name.label', default: 'Name')}" />
                        
                            <g:sortableColumn property="url" title="${message(code: 'onlineAccount.url.label', default: 'Url')}" />
                        
                            <g:sortableColumn property="userName" title="${message(code: 'onlineAccount.userName.label', default: 'User Name')}" />
                        
                            <g:sortableColumn property="password" title="${message(code: 'onlineAccount.password.label', default: 'Password')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${onlineAccountInstanceList}" status="i" var="onlineAccountInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${onlineAccountInstance.id}">${fieldValue(bean: onlineAccountInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: onlineAccountInstance, field: "name")}</td>
                        
                            <td>${fieldValue(bean: onlineAccountInstance, field: "url")}</td>
                        
                            <td>${fieldValue(bean: onlineAccountInstance, field: "userName")}</td>
                        
                            <td>${fieldValue(bean: onlineAccountInstance, field: "password")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${onlineAccountInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
