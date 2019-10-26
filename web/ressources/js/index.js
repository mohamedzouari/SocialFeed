var $magic = $(".magic");
var temps =0.01;
var num=0;
var reached =0;
jQuery(document).ready(function(){
  
 $(document).mousemove(function(e){
     
     var magicWHalf = $magic.width() / 2;
     var t = (e.pageY - magicWHalf).toString() + 'px';
     var l = (e.pageX - magicWHalf).toString() + 'px';
     var name="#magic"+num;
     var ident="magic"+num;
     var ident2="magicblur"+num;
     var ident3="magicblur2"+num;
     var doit = '<div id="'+ident+'" style="left:' + l + ';top:' + t + ';"></div>';
     t = (e.pageY - magicWHalf - 14).toString() + 'px';
     l = (e.pageX - magicWHalf - 14).toString() + 'px';
     var doit2 = '<div id="'+ident2+'" style="left:' + l + ';top:' + t + ';"></div>';
     t = (e.pageY - magicWHalf - 35).toString() + 'px';
     l = (e.pageX - magicWHalf - 35).toString() + 'px';
     var doit3 = '<div id="'+ident3+'" style="left:' + l + ';top:' + t + ';"></div>';
     num++;
     temps+=0.05;
     $('body').prepend(doit);
     $('body').prepend(doit2);
     $('body').prepend(doit3);
     var element = document.getElementById(ident);
     setTimeout(function(){element.parentNode.removeChild(element);}, 1000);
     var element2 = document.getElementById(ident2);
     setTimeout(function(){element2.parentNode.removeChild(element2);}, 1000);
     var element3 = document.getElementById(ident3);
     setTimeout(function(){element3.parentNode.removeChild(element3);}, 1000);
     
     
 }); 
});