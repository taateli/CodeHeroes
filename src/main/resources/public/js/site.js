$(document).ready(function(){
    
     
   $('#hideSuccessButton').click(function(){
       $('#hideSuccess').hide();
   });
    
    
   $('#selectAllBox').change(function(){
      var check = this.checked;
      if(check){
          $('#referenceTable input').prop('checked',true);
      }else{
          $('#referenceTable input').prop('checked',false);
      }
   });
    
    
});


