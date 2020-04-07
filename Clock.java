class ClockDemo {
    public static void main(String[] args){
        System.out.println("Выведем первое время:");
        Clock clock1 = new Clock(2387487);
        System.out.println("\nВыведем второе время:");
        Clock clock2 = new Clock(10784);
        clock1.tick();
        System.out.println("\nУвеличим первое время на секунду:");
        clock1.printClock();
        clock2.tickDown();
        System.out.println("\nУменьшим второе время на секунду:");
        clock2.printClock();
        clock1.addClock(clock2);
        System.out.println("\nСложим первый и второй час:");
        clock1.printClock();
    }
}

public class Clock {
    int hr;
    int min;
    int sec;

    public Clock(int sec){
        setClock (sec);
        printClock();
    }

    public void setClock (int seconds){
        sec = seconds % 60;
        min = (seconds/60);
        hr = min / 60;
        hr = hr % 24;
        min = min % 60;
    }

    public int getHours() {
        return hr;
    }

    public int getMinutes() {
        return min;
    }

    public int getSeconds() {
        return sec;
    }

    public void addClock(Clock secondClock){
        this.sec += secondClock.getSeconds();
        this.min+= secondClock.getMinutes();
        //add overflow to minutes from seconds
        this.min+=(int)(this.sec/60);
        //update seconds
        this.sec = this.sec % 60;
        this.hr += secondClock.getHours();
        //add overflow to minutes from seconds

        this.hr+=(int)(this.min/60);
        //update minutes
        this.min= this.min% 60;

        //adjust hours
        this.hr = this.hr%24;
    }

    public void tick(){
        this.sec += 1;
        //add overflow to minutes from seconds
        this.min+=(int)(this.sec/60);
        //update seconds
        this.sec = this.sec % 60;
        //add overflow to minutes from seconds
        this.hr+=(int)(this.min/60);
        //update minutes
        this.min= this.min% 60;
        //adjust hours
        this.hr = this.hr%24;
    }

    public void tickDown(){
        this.sec -= 1;
        if(this.sec <0){
            this.sec+=60;
            this.min-=1;
        }
        if(this.min<0){
            this.min+=60;
            this.hr-=1;
        }
        if(this.hr<0){
            this.hr+=24;
        }
    }

    public void printClock(){
        System.out.println(hr + ":"+ min + ":" + sec);
    }
}
