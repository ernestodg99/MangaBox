$(document).ready(function () {
    $('#visible').click(function (event) {
        $('#visible').hide();
        $('#divfotos').hide();
        $('#novisible').show();
        var cap = $('#idcap').val();

        $.ajax({
            type: 'POST',
            data: {
                capit: cap
            },
            url: 'SetVisibleCapitulo.htm',
            success: function (result) {
                console.log("Correcto");
            }
        });
    });

    $('#novisible').click(function (event) {
        $('#novisible').hide();
        $('#divfotos').show();
        $('#visible').show();
        var cap = $('#idcap').val();

        $.ajax({
            type: 'POST',
            data: {
                capit: cap
            },
            url: 'SetNoVisibleCapitulo.htm',
            success: function (result) {
                console.log("Correcto");
            }
        });
    });
});


