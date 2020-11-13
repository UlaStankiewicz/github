package com.micmr0.github.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class RootObject implements Parcelable {
    private int id;
    private String node_id;
    @SerializedName("name")
    private String name;
    private String full_name;
    @SerializedName("private")
    private boolean pprivate;
    private Owner owner;
    private String html_url;
    private String description;
    private boolean fork;
    private String url;
    private String forks_url;
    private String keys_url;
    private String collaborators_url;
    private String teams_url;
    private String hooks_url;
    private String issue_events_url;
    private String events_url;
    private String assignees_url;
    private String branches_url;
    private String tags_url;
    private String blobs_url;
    private String git_tags_url;
    private String git_refs_url;
    private String trees_url;
    private String statuses_url;
    private String languages_url;
    private String stargazers_url;
    private String contributors_url;
    private String subscribers_url;
    private String subscription_url;
    private String commits_url;
    private String git_commits_url;
    private String comments_url;
    private String issue_comment_url;
    private String contents_url;
    private String compare_url;
    private String merges_url;
    private String archive_url;
    private String downloads_url;
    private String issues_url;
    private String pulls_url;
    private String milestones_url;
    private String notifications_url;
    private String labels_url;
    private String releases_url;
    private String deployments_url;
    private Date created_at;
    private Date updated_at;
    private Date pushed_at;
    private String git_url;
    private String ssh_url;
    private String clone_url;
    private String svn_url;
    private String homepage;
    private int size;
    private int stargazers_count;
    private int watchers_count;
    private String language;
    private boolean has_issues;
    private boolean has_projects;
    private boolean has_downloads;
    private boolean has_wiki;
    private boolean has_pages;
    private int forks_count;
    private String mirror_url;
    private boolean archived;
    private boolean disabled;
    private int open_issues_count;
    private String license;
    private int forks;
    private int open_issues;
    private int watchers;
    private String default_branch;

    protected RootObject(Parcel in) {
        id = in.readInt();
        node_id = in.readString();
        name = in.readString();
        full_name = in.readString();
        pprivate = in.readByte() != 0;
        html_url = in.readString();
        description = in.readString();
        fork = in.readByte() != 0;
        url = in.readString();
        forks_url = in.readString();
        keys_url = in.readString();
        collaborators_url = in.readString();
        teams_url = in.readString();
        hooks_url = in.readString();
        issue_events_url = in.readString();
        events_url = in.readString();
        assignees_url = in.readString();
        branches_url = in.readString();
        tags_url = in.readString();
        blobs_url = in.readString();
        git_tags_url = in.readString();
        git_refs_url = in.readString();
        trees_url = in.readString();
        statuses_url = in.readString();
        languages_url = in.readString();
        stargazers_url = in.readString();
        contributors_url = in.readString();
        subscribers_url = in.readString();
        subscription_url = in.readString();
        commits_url = in.readString();
        git_commits_url = in.readString();
        comments_url = in.readString();
        issue_comment_url = in.readString();
        contents_url = in.readString();
        compare_url = in.readString();
        merges_url = in.readString();
        archive_url = in.readString();
        downloads_url = in.readString();
        issues_url = in.readString();
        pulls_url = in.readString();
        milestones_url = in.readString();
        notifications_url = in.readString();
        labels_url = in.readString();
        releases_url = in.readString();
        deployments_url = in.readString();
        git_url = in.readString();
        ssh_url = in.readString();
        clone_url = in.readString();
        svn_url = in.readString();
        homepage = in.readString();
        size = in.readInt();
        stargazers_count = in.readInt();
        watchers_count = in.readInt();
        language = in.readString();
        has_issues = in.readByte() != 0;
        has_projects = in.readByte() != 0;
        has_downloads = in.readByte() != 0;
        has_wiki = in.readByte() != 0;
        has_pages = in.readByte() != 0;
        forks_count = in.readInt();
        mirror_url = in.readString();
        archived = in.readByte() != 0;
        disabled = in.readByte() != 0;
        open_issues_count = in.readInt();
        license = in.readString();
        forks = in.readInt();
        open_issues = in.readInt();
        watchers = in.readInt();
        default_branch = in.readString();
    }

    public static final Creator<RootObject> CREATOR = new Creator<RootObject>() {
        @Override
        public RootObject createFromParcel(Parcel in) {
            return new RootObject(in);
        }

        @Override
        public RootObject[] newArray(int size) {
            return new RootObject[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodeId() {
        return node_id;
    }

    public void setNodeId(String node_id) {
        this.node_id = node_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return full_name;
    }

    public void setFullName(String full_name) {
        this.full_name = full_name;
    }

    public boolean getPrivate() {
        return pprivate;
    }

    public void setPrivate(boolean pprivate) {
        this.pprivate = pprivate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getHtmlUrl() {
        return html_url;
    }

    public void setHtmlUrl(String html_url) {
        this.html_url = html_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getForksUrl() {
        return forks_url;
    }

    public void setForksUrl(String forks_url) {
        this.forks_url = forks_url;
    }

    public String getKeysUrl() {
        return keys_url;
    }

    public void setKeysUrl(String keys_url) {
        this.keys_url = keys_url;
    }

    public String getCollaboratorsUrl() {
        return collaborators_url;
    }

    public void setCollaboratorsUrl(String collaborators_url) {
        this.collaborators_url = collaborators_url;
    }

    public String getTeamsUrl() {
        return teams_url;
    }

    public void setTeamsUrl(String teams_url) {
        this.teams_url = teams_url;
    }

    public String getHooksUrl() {
        return hooks_url;
    }

    public void setHooksUrl(String hooks_url) {
        this.hooks_url = hooks_url;
    }

    public String getIssueEventsUrl() {
        return issue_events_url;
    }

    public void setIssueEventsUrl(String issue_events_url) {
        this.issue_events_url = issue_events_url;
    }

    public String getEventsUrl() {
        return events_url;
    }

    public void setEventsUrl(String events_url) {
        this.events_url = events_url;
    }

    public String getAssigneesUrl() {
        return assignees_url;
    }

    public void setAssigneesUrl(String assignees_url) {
        this.assignees_url = assignees_url;
    }

    public String getBranchesUrl() {
        return branches_url;
    }

    public void setBranchesUrl(String branches_url) {
        this.branches_url = branches_url;
    }

    public String getTagsUrl() {
        return tags_url;
    }

    public void setTagsUrl(String tags_url) {
        this.tags_url = tags_url;
    }

    public String getBlobsUrl() {
        return blobs_url;
    }

    public void setBlobsUrl(String blobs_url) {
        this.blobs_url = blobs_url;
    }

    public String getGitTagsUrl() {
        return git_tags_url;
    }

    public void setGitTagsUrl(String git_tags_url) {
        this.git_tags_url = git_tags_url;
    }

    public String getGitRefsUrl() {
        return git_refs_url;
    }

    public void setGitRefsUrl(String git_refs_url) {
        this.git_refs_url = git_refs_url;
    }

    public String getTreesUrl() {
        return trees_url;
    }

    public void setTreesUrl(String trees_url) {
        this.trees_url = trees_url;
    }

    public String getStatusesUrl() {
        return statuses_url;
    }

    public void setStatusesUrl(String statuses_url) {
        this.statuses_url = statuses_url;
    }

    public String getLanguagesUrl() {
        return languages_url;
    }

    public void setLanguagesUrl(String languages_url) {
        this.languages_url = languages_url;
    }

    public String getStargazersUrl() {
        return stargazers_url;
    }

    public void setStargazersUrl(String stargazers_url) {
        this.stargazers_url = stargazers_url;
    }

    public String getContributorsUrl() {
        return contributors_url;
    }

    public void setContributorsUrl(String contributors_url) {
        this.contributors_url = contributors_url;
    }

    public String getSubscribersUrl() {
        return subscribers_url;
    }

    public void setSubscribersUrl(String subscribers_url) {
        this.subscribers_url = subscribers_url;
    }

    public String getSubscriptionUrl() {
        return subscription_url;
    }

    public void setSubscriptionUrl(String subscription_url) {
        this.subscription_url = subscription_url;
    }

    public String getCommitsUrl() {
        return commits_url;
    }

    public void setCommitsUrl(String commits_url) {
        this.commits_url = commits_url;
    }

    public String getGitCommitsUrl() {
        return git_commits_url;
    }

    public void setGitCommitsUrl(String git_commits_url) {
        this.git_commits_url = git_commits_url;
    }

    public String getCommentsUrl() {
        return comments_url;
    }

    public void setCommentsUrl(String comments_url) {
        this.comments_url = comments_url;
    }

    public String getIssueCommentUrl() {
        return issue_comment_url;
    }

    public void setIssueCommentUrl(String issue_comment_url) {
        this.issue_comment_url = issue_comment_url;
    }

    public String getContentsUrl() {
        return contents_url;
    }

    public void setContentsUrl(String contents_url) {
        this.contents_url = contents_url;
    }

    public String getCompareUrl() {
        return compare_url;
    }

    public void setCompareUrl(String compare_url) {
        this.compare_url = compare_url;
    }

    public String getMergesUrl() {
        return merges_url;
    }

    public void setMergesUrl(String merges_url) {
        this.merges_url = merges_url;
    }

    public String getArchiveUrl() {
        return archive_url;
    }

    public void setArchiveUrl(String archive_url) {
        this.archive_url = archive_url;
    }

    public String getDownloadsUrl() {
        return downloads_url;
    }

    public void setDownloadsUrl(String downloads_url) {
        this.downloads_url = downloads_url;
    }

    public String getIssuesUrl() {
        return issues_url;
    }

    public void setIssuesUrl(String issues_url) {
        this.issues_url = issues_url;
    }

    public String getPullsUrl() {
        return pulls_url;
    }

    public void setPullsUrl(String pulls_url) {
        this.pulls_url = pulls_url;
    }

    public String getMilestonesUrl() {
        return milestones_url;
    }

    public void setMilestonesUrl(String milestones_url) {
        this.milestones_url = milestones_url;
    }

    public String getNotificationsUrl() {
        return notifications_url;
    }

    public void setNotificationsUrl(String notifications_url) {
        this.notifications_url = notifications_url;
    }

    public String getLabelsUrl() {
        return labels_url;
    }

    public void setLabelsUrl(String labels_url) {
        this.labels_url = labels_url;
    }

    public String getReleasesUrl() {
        return releases_url;
    }

    public void setReleasesUrl(String releases_url) {
        this.releases_url = releases_url;
    }

    public String getDeploymentsUrl() {
        return deployments_url;
    }

    public void setDeploymentsUrl(String deployments_url) {
        this.deployments_url = deployments_url;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getPushedAt() {
        return pushed_at;
    }

    public void setPushedAt(Date pushed_at) {
        this.pushed_at = pushed_at;
    }

    public String getGitUrl() {
        return git_url;
    }

    public void setGitUrl(String git_url) {
        this.git_url = git_url;
    }

    public String getSshUrl() {
        return ssh_url;
    }

    public void setSshUrl(String ssh_url) {
        this.ssh_url = ssh_url;
    }

    public String getCloneUrl() {
        return clone_url;
    }

    public void setCloneUrl(String clone_url) {
        this.clone_url = clone_url;
    }

    public String getSvnUrl() {
        return svn_url;
    }

    public void setSvnUrl(String svn_url) {
        this.svn_url = svn_url;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStargazersCount() {
        return stargazers_count;
    }

    public void setStargazersCount(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }

    public int getWatchersCount() {
        return watchers_count;
    }

    public void setWatchersCount(int watchers_count) {
        this.watchers_count = watchers_count;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean getHasIssues() {
        return has_issues;
    }

    public void setHasIssues(boolean has_issues) {
        this.has_issues = has_issues;
    }

    public boolean getHasProjects() {
        return has_projects;
    }

    public void setHasProjects(boolean has_projects) {
        this.has_projects = has_projects;
    }

    public boolean getHasDownloads() {
        return has_downloads;
    }

    public void setHasDownloads(boolean has_downloads) {
        this.has_downloads = has_downloads;
    }

    public boolean getHasWiki() {
        return has_wiki;
    }

    public void setHasWiki(boolean has_wiki) {
        this.has_wiki = has_wiki;
    }

    public boolean getHasPages() {
        return has_pages;
    }

    public void setHasPages(boolean has_pages) {
        this.has_pages = has_pages;
    }

    public int getForksCount() {
        return forks_count;
    }

    public void setForksCount(int forks_count) {
        this.forks_count = forks_count;
    }

    public String getMirrorUrl() {
        return mirror_url;
    }

    public void setMirrorUrl(String mirror_url) {
        this.mirror_url = mirror_url;
    }

    public boolean getArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getOpenIssuesCount() {
        return open_issues_count;
    }

    public void setOpenIssuesCount(int open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public int getOpenIssues() {
        return open_issues;
    }

    public void setOpenIssues(int open_issues) {
        this.open_issues = open_issues;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }

    public String getDefaultBranch() {
        return default_branch;
    }

    public void setDefaultBranch(String default_branch) {
        this.default_branch = default_branch;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(node_id);
        dest.writeString(name);
        dest.writeString(full_name);
        dest.writeByte((byte) (pprivate ? 1 : 0));
        dest.writeString(html_url);
        dest.writeString(description);
        dest.writeByte((byte) (fork ? 1 : 0));
        dest.writeString(url);
        dest.writeString(forks_url);
        dest.writeString(keys_url);
        dest.writeString(collaborators_url);
        dest.writeString(teams_url);
        dest.writeString(hooks_url);
        dest.writeString(issue_events_url);
        dest.writeString(events_url);
        dest.writeString(assignees_url);
        dest.writeString(branches_url);
        dest.writeString(tags_url);
        dest.writeString(blobs_url);
        dest.writeString(git_tags_url);
        dest.writeString(git_refs_url);
        dest.writeString(trees_url);
        dest.writeString(statuses_url);
        dest.writeString(languages_url);
        dest.writeString(stargazers_url);
        dest.writeString(contributors_url);
        dest.writeString(subscribers_url);
        dest.writeString(subscription_url);
        dest.writeString(commits_url);
        dest.writeString(git_commits_url);
        dest.writeString(comments_url);
        dest.writeString(issue_comment_url);
        dest.writeString(contents_url);
        dest.writeString(compare_url);
        dest.writeString(merges_url);
        dest.writeString(archive_url);
        dest.writeString(downloads_url);
        dest.writeString(issues_url);
        dest.writeString(pulls_url);
        dest.writeString(milestones_url);
        dest.writeString(notifications_url);
        dest.writeString(labels_url);
        dest.writeString(releases_url);
        dest.writeString(deployments_url);
        dest.writeString(git_url);
        dest.writeString(ssh_url);
        dest.writeString(clone_url);
        dest.writeString(svn_url);
        dest.writeString(homepage);
        dest.writeInt(size);
        dest.writeInt(stargazers_count);
        dest.writeInt(watchers_count);
        dest.writeString(language);
        dest.writeByte((byte) (has_issues ? 1 : 0));
        dest.writeByte((byte) (has_projects ? 1 : 0));
        dest.writeByte((byte) (has_downloads ? 1 : 0));
        dest.writeByte((byte) (has_wiki ? 1 : 0));
        dest.writeByte((byte) (has_pages ? 1 : 0));
        dest.writeInt(forks_count);
        dest.writeString(mirror_url);
        dest.writeByte((byte) (archived ? 1 : 0));
        dest.writeByte((byte) (disabled ? 1 : 0));
        dest.writeInt(open_issues_count);
        dest.writeString(license);
        dest.writeInt(forks);
        dest.writeInt(open_issues);
        dest.writeInt(watchers);
        dest.writeString(default_branch);
    }
}
