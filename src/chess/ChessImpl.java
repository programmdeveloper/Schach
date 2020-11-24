package chess;

import java.util.HashMap;

public class ChessImpl implements Chess{

    private Status status = Status.START;
    HashMap<ChessColor, String> player = new HashMap<>();

    @Override
    public ChessColor pick(String user, ChessColor color) throws GameException, StatusException {
        if(this.status != Status.START && this.status != Status.ONE_PICKED){
            throw new StatusException("pick call but wrong status");
        }

        ChessColor takenColor = null;
        //already taken a color
        takenColor = this.getTakenColor(user, ChessColor.WHITE);
        if(takenColor == null){
            takenColor = this.getTakenColor(user, ChessColor.BLACK);
        }
        //2+ players
        if(takenColor == null && this.player.values().size() == 2){
            throw new GameException("both symbols taken but not from "+ user);
        }

        //user already got a color
        if(takenColor != null){
            //wanted one?
            if(takenColor == color) return color;

            //change - possible?
            if(this.player.get(color) == null){
                //yes
                this.player.remove(takenColor);
                this.player.put(color, user);
                return color;
            } else {
                //no
                return takenColor;
            }
        } else {
            //no color taken yet
            if(this.player.get(color) == null){
                //color available
                this.player.put(color, user);
                return color;
            } else {
                ChessColor otherColor = color == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
                this.player.put(otherColor, user);
                return otherColor;
            }
        }
    }

    private ChessColor getTakenColor(String user, ChessColor color){
        String name = this.player.get(color);
        if(name != null && name.equalsIgnoreCase(user)){
            return color;
        }
        return null;
    }

    @Override
    public boolean move(ChessColor color, ChessBoardPosition from, ChessBoardPosition to) throws GameException, StatusException {
        if(this.status != Status.ACTIVE_W && this.status != Status.ACTIVE_B){
            throw new StatusException("move call but wrong status");
        }
        return false;
    }
}
