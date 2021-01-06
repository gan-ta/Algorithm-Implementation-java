package com.hs.grammer.doubledispatch;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] arg){
        List<SmartPhone> phoneList = Arrays.asList(new Iphone(), new Gallaxy());
        Game game = new GameImpl();
        phoneList.forEach(game::play);//동적바인딩1
    }
}

interface SmartPhone{
    void game(Game game);
}

class Iphone implements SmartPhone{

    @Override
    public void game(Game game) {
        System.out.println("game play[" + this.getClass().getSimpleName() + "]");
    }
}

class Gallaxy implements  SmartPhone{

    @Override
    public void game(Game game) {
        System.out.println("game play[" + this.getClass().getSimpleName() + "]");
    }
}

interface Game{
    public void play(SmartPhone smartPhone);
}


class GameImpl implements Game{
    public void play(SmartPhone phone){
        phone.game(this);//동적 바인딩2
    }
}
