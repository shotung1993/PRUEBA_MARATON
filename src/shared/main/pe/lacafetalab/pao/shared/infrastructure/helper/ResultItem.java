package pe.lacafetalab.pao.shared.infrastructure.helper;

import java.util.Comparator;

import lombok.Getter;

@Getter
public class ResultItem {
	private Integer index;
	private Boolean success;
	private String status;

	public ResultItem(Integer index, Boolean success, String status) {
		super();
		this.index = index;
		this.success = success;
		this.status = status;
	}

	public static ResultItemComparator comparator() {
		return new ResultItemComparator();
	}

	static class ResultItemComparator implements Comparator<ResultItem> {
		@Override
		public int compare(ResultItem o1, ResultItem o2) {
			return Integer.compare(o1.getIndex(), o2.getIndex());
		}
	}
}
