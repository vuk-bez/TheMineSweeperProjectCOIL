package dataAnalysis;

public record MatchSummary(
		int matchld,
		String botType,
		String result,
		long timeMs,
		int totalClicks
		) {
	
	public int compareTo(MatchSummary other) {
        return Long.compare(this.timeMs, other.timeMs);
    }

}
