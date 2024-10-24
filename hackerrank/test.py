import requests

def getTotalGoals(team, year):
    total_goals = 0
    
    # Helper function to get total goals from API
    def fetchGoals(url):
        goals = 0
        page = 1
        
        while True:
            response = requests.get(url.format(year=year, team=team, page=page))
            data = response.json()
            
            # Loop through the data and accumulate goals
            for match in data['data']:
                if 'team1' in url:
                    goals += int(match['team1goals'])
                else:
                    goals += int(match['team2goals'])
            
            # Check if more pages exist
            if page >= data['total_pages']:
                break
            page += 1
        
        return goals
    
    # Fetch goals when the team is playing as home (team1)
    url_home = "https://jsonmock.hackerrank.com/api/football_matches?year={year}&team1={team}&page={page}"
    total_goals += fetchGoals(url_home)
    
    # Fetch goals when the team is playing as away (team2)
    url_away = "https://jsonmock.hackerrank.com/api/football_matches?year={year}&team2={team}&page={page}"
    total_goals += fetchGoals(url_away)
    
    return total_goals