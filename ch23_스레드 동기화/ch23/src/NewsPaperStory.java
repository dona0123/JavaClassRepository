// 순서 제어 필요성

class NewsPaper {
	private String todayNews;
	private boolean istodayNews = false; 

	void setTodayNews(String news) {
		todayNews = news;
		istodayNews = true; 
		
		synchronized (this) {
			notifyAll(); 
		}
	}

	String getTodayNews() {
		if (istodayNews == false) {
			try {
				synchronized (this) {
					wait(); 
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return todayNews;
	}
}

class NewsWriter extends Thread {
	private NewsPaper paper;

	NewsWriter(NewsPaper paper) {
		this.paper = paper;
	}

	@Override
	public void run() {
		paper.setTodayNews("자바의 열기가 뜨겁습니다.");
	}
}

class NewsReader extends Thread {
	private NewsPaper paper;

	NewsReader(NewsPaper paper) {
		this.paper = paper;
	}

	@Override
	public void run() {
		System.out.println("오늘의 뉴스: " + paper.getTodayNews());
	}
}

class NewsPaperStory {
	public static void main(String[] args) {
		NewsPaper paper = new NewsPaper();
		NewsReader reader = new NewsReader(paper);
		NewsWriter writer = new NewsWriter(paper);

		reader.start();
		writer.start();

		try {
			reader.join();
			writer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}