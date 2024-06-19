# Intro
Client for managing tasks in Jira.

# Endpoints
- `[GET][https://domain.atlassian.net]/projects` - Get all Projects from instance.
- `[POST][https://domain.atlassian.net]/create-issue` - Create new issue.
- `[GET][https://domain.atlassian.net]//move-issues/from/{source}/to/{destination}` - move 5 issues from [source]project to [destination]project (**use names**).

# Todo:

- [ ] Do not import wildcard (AtlassianClient.java)
- [ ] Add Configuration section in README
- [x] Move Issue from one project to another
- [x] Import Summary (title)
- [ ] Import  Issue Description
- [ ] Import priority
- [ ] Import comments
- [ ] Write test for Service and Controller
- [ ] Refactor service's moveIssue method
- [ ] Record Demo