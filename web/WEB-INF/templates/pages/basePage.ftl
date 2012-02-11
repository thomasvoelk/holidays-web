<#-- @ftlvariable name="_userIsLoggedIn" type="boolean" -->
<#-- @ftlvariable name="_logoutUrl" type="java.lang.String" -->
<#macro page>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Urlaubsrechner</title>
    <script src="https://www.google.com/jsapi?key=ABQIAAAAG5rGjD6F77Nb02-qO_70DxQVUsPvYY0ev7mBcE9xT21dYL6bQRQT-rpU2hsfj5IU7TaCrOtlPHcj3g" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/i18n/jquery.ui.datepicker-de.js" type="text/javascript"></script>
    <script src="/js/jquery.form.js" type="text/javascript"></script>
    <script src="http://www.planbox.com/feedback/feedback.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="/css/reset.css">
    <link rel="stylesheet" type="text/css" href="/css/960_12_col.css"/>
    <link rel="stylesheet" type="text/css" href="/css/text.css"/>
    <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/themes/smoothness/jquery-ui.css" media="all"/>
    <link rel="stylesheet" type="text/css" href="http://www.planbox.com/feedback/feedback.css"/>
    <link rel="stylesheet" type="text/css" href="/css/holidays.css">
</head>
<body>
<script type="text/javascript">
    FeedbackOptions.planboxToken = '732647a147763a25c3c135dc87a90282';
    FeedbackOptions.dialogTitle = 'Tell us what you think';
</script>
<div class="wrapper container_12">
    <header>
        <div class="logo grid_6">Urlaubsplaner</div>
        <nav class="grid_6">
            <ul>
                <li><a href="/">home</a></li>
                <#if _userIsLoggedIn>
                    <li><a href="/app/private/pages/user?userId=${_userId}">profil</a></li>
                    <li><a href="${_logoutUrl}">logout</a></li>
                </#if>
            </ul>
        </nav>
        <div class="clear"></div>
    </header>
    <section id="content">
        <#nested/>
    </section>
    <div class="push"></div>
</div>
<footer class="footer container_12">
    <div class="grid_12">
        <a href="http://code.google.com/appengine/" target="_blank"><img src="http://code.google.com/appengine/images/appengine-noborder-120x30.gif" alt="Powered by Google App Engine"/></a>
    </div>
</footer>
</body>
</html>
</#macro>