var twoSum = function(nums, target) {
    var m = new Map();
    var r = [];
    for(var i = 0, j = 0; i < nums.length; i++) {
        m.set(nums[i], i);
        if(m.has(target - nums[i])) {
            r[j] = i;
            r[++j] = m.get(target - nums[i]);
        }
        
    }
    return r;
};