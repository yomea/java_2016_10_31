package com.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Watched {
	private List<Watcher> watchers = new ArrayList<>();
	private Timer timer;

	public Watched() {

		// 定时器，在3s后提醒观察者
		timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				Watched.this.notiyWatcher();
				timer.cancel();
			}
		}, 3000);
	}

	public void addWatcher(Watcher watcher) {

		watchers.add(watcher);

	}

	public void deleteWatcher(Watcher watcher) {

		watchers.remove(watcher);
	}

	public void notiyWatcher() {

		for (Watcher watcher : watchers) {
			watcher.printer();
		}
	}

}
