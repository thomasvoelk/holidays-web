<#import "basePage.ftl" as master>
<@master.page>
<script type="text/javascript">
    var userId = "${_userId}";
</script>
<script type="text/javascript" src="/js/user.js"></script>
<section id="user" class="container_12">
    <h2 class="grid_12" id="emailHeader"></h2>

    <form id="userForm" action="/app/private/users/${_userId}" method="post">
        <label for="holidays">Wieviele Urlaubstage hast Du in diesem Jahr insgesamt?</label>
        <input id="holidays" name="holidays" type="text"/>
        <input id="saveButton" type="submit" value="Speichern"/>
    </form>
</section>
</@master.page>