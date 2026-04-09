for HashSet set.add(dup) -> would return true or false if item is new or already exists
so if you want to check if it already exists... or duplicate 
while adding itself you can check it by capturing the boolean value
you can avoid contains() method

--------------------- for Set<>,  add() and contains() both are O(1) function

Set<Integer> set=new HashSet<>();
        boolean duplicates = Arrays.stream(nums).anyMatch(n->{
            if(set.contains(n)) {
                return true;
            }
            return !set.add(n);            
        });
=============================================================

  boolean duplicate = Arrays.stream(nums).anyMatch(n-> set.add(n));

  for few set of numbers.. it may not differ
    but for large set of numbers..  almost operation becomes half

    ==============================================================

==============================================================
