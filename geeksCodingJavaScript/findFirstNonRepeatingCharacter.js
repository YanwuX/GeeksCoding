function findTheFirstNonRepeating (str) {
  
  var temp = new Map();
  
  for( var i = 0; i < str.length; i++) {
     if(temp.get(str.charAt(i)) == undefined) temp.set(str.charAt(i), 1); // this now 
     else temp.set(str.charAt(i) , 2); //this  
  }
  
      var count = 0;

  temp.forEach(function (key, value) {
    if(key == 1 && count < 2) {
      console.log( "the unique char is :" + value);
      count = 10;
    }
    
  }, temp);
}

findTheFirstNonRepeating("aabracadabra");