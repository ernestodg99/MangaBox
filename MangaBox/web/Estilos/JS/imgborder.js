//Este script sirve para que tanto en pc´s como en dispositivos móviles se 
//pueda clickear/pulsar en las imágenes y automáticamente aparezca un borde 
//rojo en dicha imagen, indicando que es la seleccionada por el usuario.
$('#img1').click(function () {
    $('#foto').val("Estilos/Imagenes/onepiece.png");
    $('#img1').css('border', '4px red solid');
    $('#img2').css('border', 'none');
    $('#img3').css('border', 'none');
    $('#img4').css('border', 'none');
    $('#img5').css('border', 'none');
    $('#img6').css('border', 'none');
}
);

$('#img2').click(function () {
    $('#foto').val("Estilos/Imagenes/naruto.png");
    $('#img2').css('border', '4px red solid');
    $('#img1').css('border', 'none');
    $('#img3').css('border', 'none');
    $('#img4').css('border', 'none');
    $('#img5').css('border', 'none');
    $('#img6').css('border', 'none');
}
);

$('#img3').click(function () {
    $('#foto').val("Estilos/Imagenes/bola.png");
    $('#img3').css('border', '4px red solid');
    $('#img1').css('border', 'none');
    $('#img2').css('border', 'none');
    $('#img4').css('border', 'none');
    $('#img5').css('border', 'none');
    $('#img6').css('border', 'none');
}
);

$('#img4').click(function () {
    $('#foto').val("Estilos/Imagenes/law.jpg");
    $('#img4').css('border', '4px red solid');
    $('#img1').css('border', 'none');
    $('#img2').css('border', 'none');
    $('#img3').css('border', 'none');
    $('#img5').css('border', 'none');
    $('#img6').css('border', 'none');
}
);

$('#img5').click(function () {
    $('#foto').val("Estilos/Imagenes/snaruto.png");
    $('#img5').css('border', '4px red solid');
    $('#img1').css('border', 'none');
    $('#img2').css('border', 'none');
    $('#img3').css('border', 'none');
    $('#img4').css('border', 'none');
    $('#img6').css('border', 'none');
}
);

$('#img6').click(function () {
    $('#foto').val("Estilos/Imagenes/db.jpg");
    $('#img6').css('border', '4px red solid');
    $('#img1').css('border', 'none');
    $('#img2').css('border', 'none');
    $('#img3').css('border', 'none');
    $('#img4').css('border', 'none');
    $('#img5').css('border', 'none');
}
);


