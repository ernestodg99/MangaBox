$(document).ready(function () {
    //Creamos el array
    var tabla = new Array();
    //Si pulsamos una tecla en el input con id tags llámamos al servlet 
    //AutoComplete.htm que nos devuelve un array con las series que se parezcan 
    //al resultado introducido
    $('#tags').bind('keydown', function (event) {
        var data = {nombre: $('#tags').val()};
        $.getJSON("AutoComplete.htm", data, function (res, est, jqXHR) {
            tabla.length = 0;
            $.each(res, function (i, item) {
                tabla[i] = item;
                console.log(tabla[i]);
            });
        });
    });

    $('#tags').autocomplete({
        source: tabla,
        minLength: 1
    });
});


