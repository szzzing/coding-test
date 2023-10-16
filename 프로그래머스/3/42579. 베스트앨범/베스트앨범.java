import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap();
        ArrayList<Music> musicList = new ArrayList();
        ArrayList<Integer> bestList = new ArrayList();

        for(int i=0 ; i<genres.length ; i++) {
            if(map.containsKey(genres[i])) {
                map.put(genres[i], map.get(genres[i])+plays[i]);
            } else {
                map.put(genres[i], plays[i]);
            }
        }

        for(int i=0 ; i<genres.length ; i++) {
            Music m = new Music(i, map.get(genres[i]), plays[i]);
            musicList.add(m);
        }
        Collections.sort(musicList);

        int c = 0;
        int g = 0;
        Iterator<Music> it = musicList.iterator();
        
        while(it.hasNext()) {
            Music m = it.next();
            c++;
            if(g==m.genre) {
                if(c<2) {
                    bestList.add(m.id);
                }
            } else {
                c = 0;
                g = m.genre;
                bestList.add(m.id);
            }
        }
        
        int[] answer = new int[bestList.size()];
        for(int i=0 ; i<bestList.size() ; i++) {
            answer[i] = bestList.get(i);
        }
        return answer;
    }
}

class Music implements Comparable<Music> {
    int id;
    int genre;
    int play;

    public Music(int id, int genre, int play) {
        this.id = id;
        this.genre = genre;
        this.play = play;
    }

    @Override
    public int compareTo(Music m) {
        if(this.genre!=m.genre) return m.genre-this.genre;
        else if(this.play!=m.play) return m.play-this.play;
        else return this.id-m.id;
    }
}