/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function change_size(){
       window_height = $(window).height();
       div_height = $("#manuelSwitcher").height();
       if(window_height<div_height){
          $("#manuelSwitcher").css({marginTop: "20px" , height: "20px"});
       }
}

$(document).ready(function(){
   change_size();
});
$(window).resize(function(){
   change_size();
});