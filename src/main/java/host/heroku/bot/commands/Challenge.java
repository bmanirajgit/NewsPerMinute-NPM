package host.heroku.bot.commands;

public class Challenge extends Excerpt{
    private String id;
    private boolean complete;

    public void setID(String id){
        this.id = id;
    }

    public boolean isComplete(){
        return true;
    }
}
