<#import "basePage.ftl" as master>
<@master.page>
<script type="text/javascript" src="/js/calculator.js"></script>
<section id="calendar" class="container_12">
    <h2 class="grid_12">Wann möchtest Du Urlaub nehmen?</h2>

    <form id="calculationForm" action="/app/public/workingDays" method="get">
        <div class="container_12">
            <input type="date" class="datepicker grid_4" name="localFrom" id="localFrom" readonly="readonly"/><input type="hidden" name="from" id="from"/>
            <input type="date" class="datepicker grid_4" name="localTo" id="localTo" readonly="readonly"/><input type="hidden" name="to" id="to"/>
            <button type="button" id="clearForm" class="grid_2">Löschen</button>
        </div>
    </form>
</section>


<section id="calculationResult" class="container_12" style="min-height: 50px">
    <div id="result" class="grid_12">
        Dafür benötigst Du <span id="workingDays"></span> Urlaubstage
    </div>
    <div id="inProgress" class="grid_12">
        Berechnung läuft...
    </div>
</section>
</@master.page>