package com.chandan.topic.design.DesignBrowserHistory1472;

import java.util.Stack;

class BrowserHistory {
    Stack<String> history;
    Stack<String> forward;

    public BrowserHistory(String homepage) {
        history = new Stack();
        forward = new Stack();
        history.push(homepage);
    }

    public void visit(String url) {
        forward.clear();
        history.push(url);
    }

    public String back(int steps) {
        while(steps != 0 && history.size() > 1) {
            steps--;
            forward.push(history.peek());
            history.pop();
        }
        return history.peek();
    }

    public String forward(int steps) {
        while(steps != 0 && forward.size() > 0) {
            steps--;
            history.push(forward.peek());
            forward.pop();
        }
        return history.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
