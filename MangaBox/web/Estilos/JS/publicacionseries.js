//Este script realiza las peticiones por AJAX para publicar o deshacer la 
//publicación de la serie en cuestión. También oculta/muestra los botones 
//#visible #novisible de forma que cuando se oculta uno se muestra el otro.

$(document).ready(function () {
    $('#visible').click(function (event) {
        $('#visible').hide();
        $('#novisible').show();
        var serie = $('#nombreserie').val();

        $.ajax({
            type: 'POST',
            data: {
                serie: serie
            },
            url: 'SetVisible.htm',
            success: function (result) {
                console.log("Correcto");
            }
        });
    });

    $('#novisible').click(function (event) {
        $('#novisible').hide();
        $('#visible').show();
        var serie = $('#nombreserie').val();

        $.ajax({
            type: 'POST',
            data: {
                serie: serie
            },
            url: 'SetNoVisible.htm',
            success: function (result) {
                console.log("Correcto");
            }
        });
    });
});

