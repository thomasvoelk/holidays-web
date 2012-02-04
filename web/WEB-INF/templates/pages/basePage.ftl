<#macro page>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Urlaubsrechner</title>
    <script src="https://www.google.com/jsapi?key=ABQIAAAAG5rGjD6F77Nb02-qO_70DxQVUsPvYY0ev7mBcE9xT21dYL6bQRQT-rpU2hsfj5IU7TaCrOtlPHcj3g"
            type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/jquery-ui.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/i18n/jquery.ui.datepicker-de.js"
            type="text/javascript"></script>
    <script src="js/jquery.form.js" type="text/javascript"></script>
    <script src="http://www.planbox.com/feedback/feedback.js" type="text/javascript"></script>
    <link type="text/css" rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.17/themes/sunny/jquery-ui.css"
          type="text/css" media="all"/>
    <link href="http://www.planbox.com/feedback/feedback.css" rel="stylesheet" type="text/css"/>
    <link type="text/css" rel="stylesheet" href="css/holidays.css">
</head>
<body>
<script type="text/javascript">
    FeedbackOptions.planboxToken = '732647a147763a25c3c135dc87a90282';
    FeedbackOptions.dialogTitle = 'Tell us what you think';
</script>
<div id="content">
    <#nested/>
</div>
</body>
</html>
</#macro>