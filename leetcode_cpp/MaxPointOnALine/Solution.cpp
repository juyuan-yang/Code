#include "../common/Point.h"
#include <iostream>
#include <vector>
#include <map>

using namespace std;

int main(int argc, char** argv) {
	return 0;
}

class Solution {
public:
	Solution() {}
	struct Line {
		double k;
		double y;
		bool maxK;
	};
	struct LineHasher {
		size_t operator()(const Line &l) const {
			return 31*31*l.k + 31*l.y + (l.maxK == true) ? 1 : 0;
		}
	};

	Line getLine(Point p1, Point p2) {
		Line l;
		// same point
		if(p1.x == p2.x && p1.y == p2.y) {
			l.k = 0;
			l.y = 0;
			l.maxK = false;
		} else if(p1.x == p2.x) {
			l.k = 0;
			l.y = p1.x;
			l.maxK = true;
		} else {
			l.k = (p1.y - p2.y) / (double) (p1.x - p2.x);
			l.y = (double)p1.y - (double)p1.x * l.k;
			l.maxK = false;
		}
		return l;
	}

	int maxPoints(vector<Point> &points) {
		if(points.size() == 0) return 0;
		else if(points.size() == 1) return 1;

		int max = 0;
		map<Line, int, LineHasher> line2num;
		for(int i = 0; i < points.size(); i++) {
			for(int j = 0; j < points.size(); j++) {
				if(i == j) continue;
				Line line = getLine(points[i], points[j]);
				map<Line, int>::iterator iter = line2num.find(line);
				if(iter == line2num.end()) {
					line2num.insert(pair<Line, int>(line, 1));
					if(max == 0) {
						max = 1;
					}
				} else {
					(*iter).second++;
					if(iter->second > max) {
						max = iter->second;
					}
				}
			}
		}
		return max;
	}
};
