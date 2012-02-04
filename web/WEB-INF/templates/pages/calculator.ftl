<#import "basePage.ftl" as master>
<@master.page>
<script type="text/javascript" src="/js/calculator.js"></script>
<form id="calculationForm" action="/app/public/calculate/neededDays" method="get">
    <h1>Urlaubsplanung</h1>

    <div id="calendar">
        <label for="localFrom">Von:</label>
        <input type="text" name="localFrom" id="localFrom"/><input type="hidden" name="from" id="from"/>
        <label for="localTo">Bis:</label>
        <input type="text" name="localTo" id="localTo"/><input type="hidden" name="to" id="to"/>
    </div>
    <div>
        benötigte Tage: <span id="daysNeeded"></span>
    </div>
</form>
</@master.page>