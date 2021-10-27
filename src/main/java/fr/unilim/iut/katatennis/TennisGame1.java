package fr.unilim.iut.katatennis;


public class TennisGame1 implements TennisGame {
    
    private int player1Score = 0;
    private int player2Score = 0;
    
    private String[] verbalScore = {"Love","Fifteen","Thirty","Forty",""};
    
    public TennisGame1(String player1Name, String player2Name) {
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        if (player1Score==player2Score)
        {
            score = getScoreForEquality();
        }
        else if (player1Score>=4 || player2Score>=4)
        {
            score = getScoreForProgression();
        }
        else
        {
            score = getScoreForStandard(score);
        }
        return score;
    }

	private String getScoreForStandard(String score) {
		
		return score = verbalScore[player1Score] + "-" + verbalScore[player2Score];
	}

	private String getScoreForProgression() {
		String score;
		int minusResult = player1Score-player2Score;
		if (minusResult==1) score ="Advantage player1";
		else if (minusResult ==-1) score ="Advantage player2";
		else if (minusResult>=2) score = "Win for player1";
		else score ="Win for player2";
		return score;
	}

	private String getScoreForEquality() {
		if (player1Score > 2) {
			return "Deuce";
		}
		return verbalScore[player1Score]+"-All";
	}
}