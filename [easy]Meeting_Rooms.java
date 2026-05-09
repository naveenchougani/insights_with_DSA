// like we will have list or intervals and [1,2] [3,4] .. so this is no conflict he can attend all meeting.. so true
// if [1,5][3,7]  here next meeting start 3 is previos meeting end 5 are both in a same range on conflict.. and he cannot be in two meeting at a time
// so return false.  The main problem is the array or list is not sorted
// As per this problem description and online suggestions
// maximum array size is 500 which is very cheap operation to srot the array/list
// But the number of values in 500 may go upto 1,000,000 (10 laksh value) so.. to make it o(N) without extra time..
// You need an array[10lakh] to store that times stamp as true or visitied and that much of array takes a lot of MBs and expensive than O(NlogN) our sorted appraoch
// Hence we would sort the array and it gives us clean approach without ambiguity>
// Because without sorting.. you need every interval need to be checked with all other intervals which would become expensive like O(n2)
// so sort it make life easy

  public boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.size()==0 || intervals.size()==1) {
            return true;
        }

        intervals.sort((a,b) -> Integer.compare(a.start,b.start) );

        int previousEnd =0, currentStart=0,count=1;
       // boolean canAttend=true;

        // HEre if you use traditional for loop with i=1, so previousEnd can get by get(i-1) and current one is get(i)
        // no need of count here.. but as we are using enhanced for loop this is the option
        for(var interval:intervals) {

            if(count==1) {
                previousEnd = interval.end;
                count++;
                continue;
            }
            currentStart=interval.start;

            if(previousEnd > currentStart)
                return false;
            
            previousEnd = interval.end;
            
        }

        return true;

    }
